package github.leavesc.databinding

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import github.leavesc.databinding.databinding.ActivityMain6Binding

/**
 * 作者：leavesC
 * 时间：2020/6/29 22:51
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://juejin.im/user/57c2ea9befa631005abd00c6
 */
class MainActivity6 : AppCompatActivity() {

    private lateinit var binding: ActivityMain6Binding

    private lateinit var user: UserBean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main6)
        user = UserBean("leavesC", "12345")
        binding.userInfo = user
        binding.userPresenter = UserPresenter(this, user, binding)
    }

    class UserPresenter(
        private val context: Context,
        private val user: UserBean,
        private val binding: ActivityMain6Binding
    ) {

        fun onUserNameClick(user: UserBean) {
            Toast.makeText(context, "用户名：" + user.name, Toast.LENGTH_SHORT).show()
        }

        fun afterTextChanged(s: Editable) {
            user.name = s.toString()
            binding.userInfo = user
        }

        fun afterUserPasswordChanged(s: Editable) {
            user.password = s.toString()
            binding.userInfo = user
        }

    }

}