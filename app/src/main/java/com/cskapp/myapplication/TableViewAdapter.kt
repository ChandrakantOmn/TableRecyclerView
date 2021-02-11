package com.cskapp.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.table_list_item.view.*

class TableViewAdapter(private val list: List<AppModel>) : RecyclerView.Adapter<TableViewAdapter.RowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.table_list_item, parent, false)
        return RowViewHolder(itemView)
    }

    private fun setHeaderBg(view: View) {
        view.setBackgroundResource(R.drawable.table_header_cell_bg)
    }

    private fun setContentBg(view: View) {
        view.setBackgroundResource(R.drawable.table_content_cell_bg)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val rowPos = holder.adapterPosition

        if (rowPos == 0) {
            // Header Cells. Main Headings appear here
            holder.itemView.apply {
                setHeaderBg(txtAppName)
                setHeaderBg(txtVersion)

                txtAppName.text = "System Information"
                txtVersion.text = ""
            }
        } else {
            val modal = list[rowPos - 1]

            holder.itemView.apply {
                setContentBg(txtAppName)
                setContentBg(txtVersion)

                txtAppName.text = modal.appName
                txtVersion.text = modal.version.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1 // one more to add header row
    }
    inner class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}