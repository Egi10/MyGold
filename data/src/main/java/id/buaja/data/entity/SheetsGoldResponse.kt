package id.buaja.data.entity

import com.google.gson.annotations.SerializedName

data class SheetsGoldResponse(

	@field:SerializedName("records")
	val records: List<RecordsItem>? = null
)

data class RecordsItem(

	@field:SerializedName("sumber")
	val sumber: String? = null,

	@field:SerializedName("berat")
	val berat: Int? = null,

	@field:SerializedName("satuan")
	val satuan: String? = null,

	@field:SerializedName("link_image")
	val linkImage: String? = null,

	@field:SerializedName("uraian")
	val uraian: String? = null,

	@field:SerializedName("total_harga")
	val totalHarga: Int? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
)
