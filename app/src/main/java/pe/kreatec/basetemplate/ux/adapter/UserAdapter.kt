package pe.kreatec.basetemplate.ux.adapter

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import pe.kreatec.basetemplate.R
import pe.kreatec.basetemplate.databinding.ItemUserBinding
import pe.kreatec.basetemplate.remote.response.UserResponse
import pe.kreatec.basetemplate.util.ext.inflater
import pe.kreatec.basetemplate.util.ui.list.BindingViewHolder

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var users = listOf<UserResponse?>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder = UserViewHolder(parent)

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position) ?: return
        holder.binding.user = user
    }

    override fun getItemCount(): Int = users.size
    private fun getItem(position: Int): UserResponse? = users[position]

    class UserViewHolder(
        parent: ViewGroup,
        val binding: ItemUserBinding = DataBindingUtil.inflate(parent.inflater(), R.layout.item_user, parent, false)
    ) : BindingViewHolder<ItemUserBinding>(binding.root, {})

}