package com.org.d3if3025.ass1fix

import android.content.Context
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

open class SwipeGesture (context : Context) : ItemTouchHelper.SimpleCallback (0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){

    val deleteColor = ContextCompat.getColor(context,R.color.deletecolor)
    val archiveColor = ContextCompat.getColor(context,R.color.deletecolor)
    val deleteIcon = R.drawable.baseline_delete_24
    val activeIcon = R.drawable.baseline_archive_24

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
       return false
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean

        RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    .addSwipeLeftBackgroundColor(deleteColor)
    .addSwipeLeftActionIcon(deleteIcon)
    .addSwipeRightActionIcon(deleteIcon)
    .addSwipeRightABackgroundColor.(deleteIcon)
    .addActionIcon(R.drawable.Cari)
    .create()
    .decorate()
    )



    {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

}