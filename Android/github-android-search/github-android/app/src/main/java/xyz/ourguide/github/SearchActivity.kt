package xyz.ourguide.github

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.operators.observable.ObservableZip
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.item_search.view.*
import xyz.ourguide.github.net.Repo
import xyz.ourguide.github.net.RepoSearchResult
import xyz.ourguide.github.net.provideGithubApi
import java.util.function.BiFunction

// RxJava
//   : 'Collection'을 다루는 연산은 일반화되어 있다.
//     (List, Set, Map)
//   -> map, filter, flatMap, zip ...

//   : 비동기에 대한 부분은 일반화되어 있지 않다.

//    Iterable           Observable
//    Iterator(pull)     Observer(push)

// 1. Observable
//  : 이벤트를 만들어내는 주체로, 이벤트 스트림을 통해 이벤트를 내보낸다.
//    한개부터 여러개의 이벤트를 만들어 낼 수도 있고, 다 하나의 이벤트도 만들어내지 않을 수 있습니다.

// 2. Observer
//   : Observable에서 만들어진 이벤트에 반응(react)하는 객체, 이벤트를 받았을 때 수행할 작업을
//     정의합니다.
//    "Observer"가 "Observable"을 구독(subscribe)합니다.

// 3. Operator
//   : 연산자는 이벤트 스트림을 통해 전달되는 이벤트를 변환합니다.
//     이벤트를 다른 이벤트 형태로 변환하거나, (map)
//     이벤트가 특정 조건에 만족하는지 필터하거나, (filter)
//     이벤트를 확장하거나, (flatMap)
//     ...

// 4. Scheduler
//   : 작업을 수행할 스레드를 지정할 수 있습니다.
//   UI Thread / IO Thread / Worker Thread / New Thread
//    observerOn: 관찰자가 수행되는 스레드
//    subscribeOn: 관찰의 대상이 수행되는 스레드

// 5. Disposable
//    Observable <- Observer 구독할때 생기는 객체로 내부적으로 생겨나는 리소스를 관리합니다.
//   => 더 이상 사용하지 않을 경우, 명시적으로 종료해야 합니다.


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
operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    this.add(disposable)
}

class SearchActivity : AppCompatActivity() {
    companion object {
        val TAG: String = SearchActivity::class.java.simpleName
    }

    val adapter = SearchResultAdapter()
    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchResultRecyclerView.layoutManager = LinearLayoutManager(this)
        searchResultRecyclerView.adapter = adapter

        val a: Observable<RepoSearchResult> = provideGithubApi(this).rxSearchRepositories("hello")
        val b: Observable<RepoSearchResult> = provideGithubApi(this).rxSearchRepositories("hello")

        // 숙제!

        /*
            compositeDisposable += provideGithubApi(this)
                .rxSearchRepositories("hello")
                .observeOn(AndroidSchedulers.mainThread())  // !!!!!!!
                .doOnSubscribe {
                    // 구독이 시작되었을 때 수행할 작업
                }
                .doOnTerminate {
                    // 성공 또는 실패를 통해 종료되었을 때 작업
                }
                .subscribe({ result ->
                    // onNext
                    adapter.items = result.items
                }, { throwable ->
                    // onError
                }, {
                    // onComplete
                })
        */

        // compositeDisposable.add(disposable)

        // disposable.dispose()

        /*
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
        */
    }

    override fun onDestroy() {
        super.onDestroy()

        // 등록된 모든 이벤트 스트림의 자원이 해지됩니다.
        compositeDisposable.dispose()
    }
}

// A() -> a
// B() -> b
// C(a, b)
// A({
//    B({
//        C(a, b, {
//        });
//    })
// })

// 비동기의 흐름을 제어하는 가장 좋은 방법 - Rx(Reactive Extension)
//  => 에릭 마이어























