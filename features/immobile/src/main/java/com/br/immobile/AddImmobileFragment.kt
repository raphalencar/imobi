package com.br.immobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.rba.common.base.BaseFragment
import br.com.rba.common.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AddImmobileFragment : BaseFragment() {

    private val viewModel: AddImmobileViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_immobile, container, false)
    }

    override fun getViewModel(): BaseViewModel = viewModel
}
