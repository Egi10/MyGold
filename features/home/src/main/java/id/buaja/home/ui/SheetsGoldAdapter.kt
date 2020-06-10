package id.buaja.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.buaja.abstraction.until.ext.formatRupiah
import id.buaja.abstraction.until.ext.formatTo
import id.buaja.abstraction.until.ext.toDate
import id.buaja.data.entity.RecordsItem
import id.buaja.home.R
import kotlinx.android.synthetic.main.item_list_home.view.*

/**
 * Created By Julsapargi Nursam 3/27/20
 */

class SheetsGoldAdapter(
    private val data: List<RecordsItem>
) : RecyclerView.Adapter<SheetsGoldAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_home, parent, false)
        )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(data[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: RecordsItem) {
            with(itemView) {
                tvKet.text = String.format("%s - %s %s", item.uraian, item.berat, item.satuan)
                tvTotalPrice.text = item.totalHarga.toString().formatRupiah()
                tvTimeStamp.text = if (item.timestamp.isNullOrEmpty()) {
                    "-"
                } else {
                    item.timestamp?.toDate()?.formatTo("EEEE, dd MMMM yyyy")
                }
                tvSource.text = item.sumber
            }
        }
    }
}