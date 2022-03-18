package com.example.volumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView

    companion object {
        private const val STATE_HASIL = "state_hasil"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPanjang = findViewById(R.id.edt_Panjang)
        edtLebar = findViewById(R.id.edt_Lebar)
        edtTinggi = findViewById(R.id.edt_Tinggi)
        btnHitung = findViewById(R.id.btn_Hitung)
        tvHasil = findViewById(R.id.tv_Hasil)

        btnHitung.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_HASIL)
            tvHasil.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_HASIL, tvHasil.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_Hitung) {
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()
            val inputTinggi = edtTinggi.text.toString().trim()

            var emptyField = false

            when {
                inputPanjang.isEmpty() -> {
                    emptyField = true
                    edtPanjang.error = "Field ini tidak boleh kosong!"
                }
                inputLebar.isEmpty() -> {
                    emptyField = true
                    edtLebar.error = "Field ini tidak boleh kosong!"
                }
                inputTinggi.isEmpty() -> {
                    emptyField = true
                    edtTinggi.error = "Field ini tidak boleh kosong!"
                }
            }

            if (!emptyField) {
                val rumus = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                tvHasil.text = rumus.toString()
            }
        }
    }
}