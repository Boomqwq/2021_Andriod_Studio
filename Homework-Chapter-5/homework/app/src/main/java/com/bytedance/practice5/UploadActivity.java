package com.bytedance.practice5;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bytedance.practice5.model.Message;
import com.bytedance.practice5.model.UploadResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UploadActivity extends AppCompatActivity {
    private static final String TAG = "chapter5";
    private static final long MAX_FILE_SIZE = 2 * 1024 * 1024;
    private static final int REQUEST_CODE_COVER_IMAGE = 101;
    private static final String COVER_IMAGE_TYPE = "image/*";
    private IApi api;
    private Uri coverImageUri;
    private SimpleDraweeView coverSD;
    private EditText toEditText;
    private EditText contentEditText ;

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNetwork();
        setContentView(R.layout.activity_upload);
        coverSD = findViewById(R.id.sd_cover);
        toEditText = findViewById(R.id.et_to);
        contentEditText = findViewById(R.id.et_content);
        findViewById(R.id.btn_cover).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFile(REQUEST_CODE_COVER_IMAGE, COVER_IMAGE_TYPE, "????????????");
            }
        });


        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_CODE_COVER_IMAGE == requestCode) {
            if (resultCode == Activity.RESULT_OK) {
                coverImageUri = data.getData();
                coverSD.setImageURI(coverImageUri);

                if (coverImageUri != null) {
                    Log.d(TAG, "pick cover image " + coverImageUri.toString());
                } else {
                    Log.d(TAG, "uri2File fail " + data.getData());
                }

            } else {
                Log.d(TAG, "file pick fail");
            }
        }
    }

    private void initNetwork() {
        //TODO 3
        // ??????Retrofit??????
        // ??????api??????
        api = retrofit.create(IApi.class);
    }

    private void getFile(int requestCode, String type, String title) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(type);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false);
        intent.putExtra(Intent.EXTRA_TITLE, title);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, requestCode);
    }

    private void submit() {
        byte[] coverImageData = readDataFromUri(coverImageUri);
        if (coverImageData == null || coverImageData.length == 0) {
            Toast.makeText(this, "???????????????", Toast.LENGTH_SHORT).show();
            return;
        }
        String to = toEditText.getText().toString();
        if (TextUtils.isEmpty(to)) {
            Toast.makeText(this, "?????????TA?????????", Toast.LENGTH_SHORT).show();
            return;
        }
        String content = contentEditText.getText().toString();
        if (TextUtils.isEmpty(content)) {
            Toast.makeText(this, "??????????????????TA?????????", Toast.LENGTH_SHORT).show();
            return;
        }

        if ( coverImageData.length >= MAX_FILE_SIZE) {
            Toast.makeText(this, "????????????", Toast.LENGTH_SHORT).show();
            return;
        }
        //TODO 5
        // ??????api.submitMessage()??????????????????
        // ???????????????????????????activity???????????????toast
        MultipartBody.Part fromPart = MultipartBody.Part.createFormData("from",Constants.USER_NAME);
        MultipartBody.Part toPart = MultipartBody.Part.createFormData("to",to);
        MultipartBody.Part contentPart = MultipartBody.Part.createFormData("content",content);
        MultipartBody.Part coverPart = MultipartBody.Part.createFormData("image", "cover.png", RequestBody.create(MediaType.parse("multipart/form-data"), coverImageData));

        Call<UploadResponse> call = api.submitMessage(
                    Constants.STUDENT_ID, "",fromPart,toPart,contentPart,coverPart,Constants.token);

        call.enqueue(new Callback<UploadResponse>() {
            @Override
            public void onResponse(final Call<UploadResponse> call, final Response<UploadResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(UploadActivity.this, "????????????", Toast.LENGTH_SHORT).show();
                    return;
                }
                final UploadResponse repoList = response.body();
                if (repoList == null) {
                    return;
                }
                finish();
            }

            @Override
            public void onFailure(final Call<UploadResponse> call, final Throwable t) {
                t.printStackTrace();
            }
        });



          //TODO??? ????????????Retrofit
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                MultipartBody.Part fromPart = MultipartBody.Part.createFormData("from",Constants.USER_NAME);
//                MultipartBody.Part toPart = MultipartBody.Part.createFormData("to",to);
//                MultipartBody.Part contentPart = MultipartBody.Part.createFormData("content",content);
//                MultipartBody.Part coverPart = MultipartBody.Part.createFormData("image", "cover.png", RequestBody.create(MediaType.parse("multipart/form-data"), coverImageData));
//
//                Call<List<UploadResponse>> call = api.submitMessage(
//                        Constants.STUDENT_ID, "",fromPart,toPart,contentPart,coverPart,Constants.token);
//
//                try {
//                    Response<List<UploadResponse>> response = call.execute();
//                    if (response.isSuccessful() && !response.body().isEmpty()) {
//                        new Handler(getMainLooper()).post(new Runnable() {
//                            @Override
//                            public void run() {
//                                System.exit(0);
//                                overridePendingTransition(0, 0);
//                            }
//                        });
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }


    // TODO 7 ?????? ???URLConnection?????????????????????
    private void submitMessageWithURLConnection(){

    }


    private byte[] readDataFromUri(Uri uri) {
        byte[] data = null;
        try {
            InputStream is = getContentResolver().openInputStream(uri);
            data = Util.inputStream2bytes(is);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
