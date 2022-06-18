package com.example.userprofile23_1.Translate;

import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.userprofile23_1.Translate.com.baidu.translate.demo.TransApi;

public class Translate {
    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20211205001019629";
    private static final String SECURITY_KEY = "qVQKUvWawyCHBzWw7FGE";
    private static final String TAG = "tag";

    public static String translate(String words) {
//        String result = HttpRequest.searchWord("翻译前内容");	//中文翻译英文
//        JSONObject jsonObject = JSONObject.parseObject(result);	//解析json字段
//
//        com.alibaba.fastjson2.JSONArray jsonArray = (com.alibaba.fastjson2.JSONArray) jsonObject.get("translation");	//解析json数组字段
//        String content1 = new String();
//        content1 += jsonArray.get(0);	//jsonArray数组中只有一个元素，所以直接取第一个元素
        //有道翻译完成，写入content1中

        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String query = words;
        String str = api.getTransResult(query, "auto", "auto");    //翻译
        JSONObject  jsonObj = JSONObject.parseObject(str);    //解析json字段
        com.alibaba.fastjson2.JSONArray  js = (com.alibaba.fastjson2.JSONArray) jsonObj.get("trans_result");	//解析json数组字段
        jsonObj = (JSONObject) js.get(0);	//js数组中只有一个元素，所以直接取第一个元素
        String content2 = new String();
        content2 += jsonObj.get("dst");
        //百度翻译完成，写入content2中

//        Log.d(TAG, "有道翻译结果：\n"+content1);
        Log.d(TAG, "百度翻译结果：\n"+content2);
        return content2;
    }
}
