package com.example.part3.chapter07

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.part3.chapter07.databinding.ActivityMainBinding
import com.example.part3.chapter07.model.ContentEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()
    private val adapter by lazy {
        ListAdapter(Handler())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@MainActivity
            recyclerView.adapter = adapter
            val decoration = DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL)
            recyclerView.addItemDecoration(decoration)
        }

        lifecycleScope.launch {
            viewModel.contentList
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collectLatest {
                    binding.emptyTextView.isVisible = it.isEmpty()
                    binding.recyclerView.isVisible = it.isNotEmpty()
                    adapter.submitList(it)
                }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickAdd() {
        InputActivity.start(this)
    }

    inner class Handler {
        fun onClickItem(item: ContentEntity) {
            InputActivity.start(this@MainActivity, item)
        }

        fun onLongClickItem(item: ContentEntity) : Boolean {
            viewModel.deleteItem(item)
            Toast.makeText(
                this@MainActivity,
                "데이터가 삭제되었습니다.",
                Toast.LENGTH_SHORT
            ).show()
            return false
        }

        fun onCheckedItem(item: ContentEntity, checked: Boolean) {
            viewModel.updateItem(item.copy(isDone = checked))
        }
    }
}