package se.roshauw.cryptocurrencyrates.currency

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import se.roshauw.cryptocurrencyrates.R

import se.roshauw.cryptocurrencyrates.currency.CurrencyFragment.OnListFragmentInteractionListener
import se.roshauw.cryptocurrencyrates.currency.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyCurrencyRecyclerViewAdapter(private val mValues: List<DummyItem>, private val mListener: OnListFragmentInteractionListener?) : RecyclerView.Adapter<MyCurrencyRecyclerViewAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return mValues.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_currency, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.mIdView.text = mValues[position].id
        holder.mContentView.text = mValues[position].content

        holder.mView.setOnClickListener {
            val item = holder.mItem
            if (item != null) {
                mListener!!.onListFragmentInteraction(item)
            }
        }
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView
        val mContentView: TextView
        var mItem: DummyItem? = null

        init {
            mIdView = mView.findViewById(R.id.key) as TextView
            mContentView = mView.findViewById(R.id.content) as TextView
        }

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
