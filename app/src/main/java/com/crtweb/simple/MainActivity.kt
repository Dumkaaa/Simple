package com.crtweb.simple


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.setContentView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainView().setContentView(this)
    }

    fun tryLogin(ui: AnkoContext<MainActivity>) {
        VKSdk.login(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (!VKSdk.onActivityResult(
                requestCode,
                resultCode,
                data,
                object : VKCallback<VKAccessToken> {
                    // Пользователь успешно авторизовался
                    override fun onResult(res: VKAccessToken) {
                    }
                    // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                    override fun onError(error: VKError) {
                    }
                }
        )) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
