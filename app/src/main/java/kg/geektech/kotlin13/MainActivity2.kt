package kg.geektech.kotlin13

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlin13.MainActivity.Companion.text
import kg.geektech.kotlin13.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var adapter: SecondAdapter

    private lateinit var binding: ActivityMain2Binding

    private var list = arrayListOf<Int>()

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        registerForActivity()
        intent.getIntegerArrayListExtra(text)?.let {
            list.addAll(it)
        }
        initRecycler()
    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                result.data?.getIntegerArrayListExtra(text)?.let {
                    list.addAll(it)
                }
                }
            }
    }
    private fun initRecycler(){
        adapter = SecondAdapter()
        adapter.setList(list)
        binding.rvMain2.adapter = adapter
    }
}