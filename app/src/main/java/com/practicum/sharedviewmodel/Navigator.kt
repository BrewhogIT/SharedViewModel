package com.practicum.sharedviewmodel

import androidx.fragment.app.Fragment

fun Fragment.navigator() : Navigator{
    return requireActivity() as Navigator
}

interface Navigator {

    fun goBack()
    fun openSecondFragment()
}