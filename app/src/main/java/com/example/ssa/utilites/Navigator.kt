package com.example.ssa.utilites

import androidx.fragment.app.Fragment
import java.util.Stack

interface Navigator {
    fun fragNavigation(fragment: Fragment, addToStack: Boolean)
}