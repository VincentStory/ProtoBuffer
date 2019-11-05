package com.fuyi.example.im.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;

import com.google.protobuf.InvalidProtocolBufferException;

import app.xlui.example.im.R;
import tutorial.Dataformat;

@SuppressWarnings({"FieldCanBeLocal", "ResultOfMethodCallIgnored", "CheckResult"})
public class BroadcastActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        String base64 = "CgMyMDASATIa3gZbeyJ0b3RhbFByb2ZpdEFuZExvc3MiOi0yMjEuNjEsInRvdGFsUGVyY2VudGFnZU9mUHJvZml0QW5kTG9zcyI6LTAuMjIxNiwidG90YWxTZWN1cml0eURlcG9zaXQiOjEwMDAuMDAsInRyYW5zYWN0aW9uVHlwZSI6MiwicmVhbE9yVmlydHVhbCI6MiwiaXNRdWFudGl0YXRpdmUiOjIsImN1cnJlbmN5SWQiOjksImN1cnJlbmN5TmFtZSI6IkJUQy9VU0RUIiwic29ja2V0T2RlckluZm9WT1MiOlt7ImlkIjoxODUzMTUsIm9yZGVyTm8iOiJhYzc3MDNmYWJmYTQ0MGU2YjkyNDAxNWU0MTY2ZTdkMiIsInVzZXJJZCI6bnVsbCwidXNlck5hbWUiOm51bGwsInVzZXJBY2NvdW50IjpudWxsLCJjdXJyZW5jeUlkIjpudWxsLCJjdXJyZW5jeU5hbWUiOm51bGwsImxldmVyYWdlTnVtYmVyIjoxMCwic2VjdXJpdHlEZXBvc2l0IjoxMDAwLjAwLCJvcGVuUHJpY2UiOjk0MjIuOTkwMDAwMDAsImNsb3NlUHJpY2UiOjkyMTMuOTIsImhvbGRQcmljZSI6bnVsbCwicHJvZml0QW5kTG9zcyI6LTIyMS42MSwiaGFuZGxpbmdGZWUiOm51bGwsInN0b3BQcm9maXQiOm51bGwsInN0b3BMb3NzIjowLjgwMDAwMDAwLCJzdG9wUHJvZml0UHJpY2UiOm51bGwsInN0b3BMb3NzUHJpY2UiOjg2NjguMjc0MDAwMDAsIm9yZGVyU3RhdHVzIjpudWxsLCJ1cHNBbmREb3duc1R5cGUiOjEsInRyYW5zYWN0aW9uTnVtYmVyIjoxLjA2LCJ0cmFuc2FjdGlvblR5cGUiOjIsIm9wdGlvblRpbWVMaW5lIjpudWxsLCJpc1F1YW50aXRhdGl2ZSI6MiwicGVyY2VudGFnZU9mUHJvZml0QW5kTG9zcyI6LTAuMjIxNiwicHJvZml0IjpudWxsLCJjcmVhdGVUaW1lIjoxNTcyOTIyMzA2MDAwLCJ1cGRhdGVUaW1lIjpudWxsfV0sImNyYXRlVGltZSI6MTU3MjkyMjMwNjAwMH1d";


        byte[] bol = getBytefromBase64(base64);


        try {
            //通过byte[]获取到json字符串
            Dataformat.ReturnVO returnVO = Dataformat.ReturnVO.parseFrom(bol);
            Log.i("data==", returnVO.getData());


        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }


    public byte[] getBytefromBase64(String base64) {
        byte[] bytes = Base64.decode(base64, Base64.DEFAULT);
        return bytes;
    }

}
