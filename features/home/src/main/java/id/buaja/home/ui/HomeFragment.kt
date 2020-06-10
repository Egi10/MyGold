package id.buaja.home.ui

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import id.buaja.abstraction.base.BaseFragment
import id.buaja.abstraction.until.ext.formatRupiah
import id.buaja.data.entity.RecordsItem
import id.buaja.home.R
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {
    private val viewModel by viewModel<HomeViewModel>()

    private lateinit var sheetsGoldAdapter: SheetsGoldAdapter
    private var list: MutableList<RecordsItem> = mutableListOf()

    override fun contentView(): Int {
        return R.layout.home_fragment
    }

    override fun initObservable() {
        with(viewModel) {
            state.observe(this@HomeFragment, Observer {
                swipeRefresh.isRefreshing = it
            })

            sheetGold.observe(this@HomeFragment, Observer {
                list.clear()
                list.addAll(it)
                sheetsGoldAdapter.notifyDataSetChanged()
            })

            totalPrice.observe(this@HomeFragment, Observer {
                tvTotalPrice.text = it.toString().formatRupiah()
            })

            totalWeight.observe(this@HomeFragment, Observer {
                tvTotalGold.text = String.format("%s gr", it.toString())
            })

            message.observe(this@HomeFragment, Observer {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            })

            error.observe(this@HomeFragment, Observer {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            })
        }
    }

    override fun initView() {
        swipeRefresh.post {
            viewModel.getSheetsGold()
        }

        swipeRefresh.setOnRefreshListener {
            viewModel.getSheetsGold()
        }

        sheetsGoldAdapter = SheetsGoldAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = sheetsGoldAdapter
    }
}