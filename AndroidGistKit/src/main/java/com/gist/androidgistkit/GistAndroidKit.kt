package com.gist.androidgistkit

import android.content.Context
import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class GistAndroidKit {
    fun load(mContext: Context?, list: List<String?>?): Intent? {
        val flutterEngine = FlutterEngine(mContext!!)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault(), list
        )
        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)
        return FlutterActivity.withCachedEngine("my_engine_id").build(
            mContext
        )
    }
}