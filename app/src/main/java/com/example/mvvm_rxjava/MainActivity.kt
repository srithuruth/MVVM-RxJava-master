package com.example.mvvm_rxjava

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()
    lateinit var viewModel: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = CalculatorViewModel()


        btnAdd.setOnClickListener {
            viewModel.add(
                etNumberOne.text.toString(),
                etNumberTwo.text.toString()
            )
        }

        btnSubtract.setOnClickListener {
            viewModel.subtract(
                etNumberOne.text.toString(),
                etNumberTwo.text.toString()
            )
        }

        btnMultiply.setOnClickListener {
            viewModel.multiply(
                etNumberOne.text.toString(),
                etNumberTwo.text.toString()
            )
        }

        btnDivide.setOnClickListener {
            viewModel.divide(
                etNumberOne.text.toString(),
                etNumberTwo.text.toString()
            )
        }
    }

    override fun onStart() {
        super.onStart()
        compositeDisposable.add(viewModel.resultObservable
            .filter { it.toInt() > 5 }
            .map { it.plus("Result") }
            .map { it.toUpperCase() }
            .subscribe { result ->
                tvResult.text = result
            })

    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }
}
