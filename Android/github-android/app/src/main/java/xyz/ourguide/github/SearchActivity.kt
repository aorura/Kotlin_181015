package xyz.ourguide.github

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.item_search.view.*
import xyz.ourguide.github.net.Repo
import xyz.ourguide.github.net.provideGithubApi

// Data <-> RecyclerView
class SearchResultAdapter(items: List<Repo> = emptyList()) :
    RecyclerView.Adapter<SearchResultAdapter.RepoViewHolder>() {

    var items = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = RepoViewHolder(parent)

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val model = items[position]

        // holder.itemView.fullNameTextView.text = model.fullName
        // holder.itemView.ownerTextView.text = model.owner.login
        with(holder.itemView) {
            fullNameTextView.text = model.fullName
            ownerTextView.text = model.owner.login

            GlideApp.with(context)
                .load(model.owner.avatarUrl)
                .into(avatarImageView)
        }
    }


    class RepoViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search, parent, false)
    )
}


// ListView -> RecyclerView

class SearchActivity : AppCompatActivity() {
    companion object {
        val TAG: String = SearchActivity::class.java.simpleName
    }

    val adapter = SearchResultAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchResultRecyclerView.layoutManager = LinearLayoutManager(this)
        searchResultRecyclerView.adapter = adapter

        provideGithubApi(this)
            .searchRepositories("hello")
            .enqueue { result ->

                result.body()?.let {
                    adapter.items = it.items
                    // adapter.notifyDataSetChanged()
                }

                /*
                val totalCount = result.body()?.totalCount
                totalCount?.let {
                    Log.i(TAG, "totalCount: $totalCount")
                }
                */
            }
    }
}















