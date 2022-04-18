package kg.geektech.kotlin13

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.kotlin13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: Adapter

    private var list = arrayListOf<Int>()

    private var imagelist = arrayListOf<Int>()

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createList()
        initRecycler()
        registerForActivity()
        binding.fap.setOnClickListener{
            openActivity(imagelist)
        }
    }

    private fun createList() {
        for (i in 1..15) {
            list.add(R.drawable.img)
            list.add(R.drawable.image11)
            list.add(R.drawable.img_1)
        }
    }

    private fun initRecycler() {
        adapter = Adapter(object : Adapter.OnClick {
            override fun onClick(image: Int) {
                imagelist.add(image)
            }

            override fun deleteClick(image: Int) {

            }

        })
        adapter.setList(list)
        binding.rvMain1.adapter = adapter
    }

    private fun openActivity(imageView: ArrayList<Int>) {
        Intent(this, MainActivity2::class.java).apply {
            putExtra(text,imageView)
            resultLauncher.launch(this)
        }
    }

    companion object {
        const val text = "Key"
    }
    private fun registerForActivity () {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if (result.resultCode == Activity.RESULT_OK){
                Log.e("TAG", "registerForActivity: $result" )
            }
        }
    }

}