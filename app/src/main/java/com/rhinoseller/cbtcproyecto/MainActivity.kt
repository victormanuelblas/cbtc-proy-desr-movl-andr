package com.rhinoseller.cbtcproyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var ilClinNombres: TextInputLayout
    lateinit var ilClinApellidos: TextInputLayout
    lateinit var ilClinTelefono: TextInputLayout
    lateinit var ilClinCorreo: TextInputLayout
    lateinit var ilClinObserv: TextInputLayout
    lateinit var etClinNombres: EditText
    lateinit var etClinApellidos: EditText
    lateinit var etClinTelefono: EditText
    lateinit var etClinCorreo: EditText
    lateinit var etClinObserv: EditText

    lateinit var btnClinSiguiente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Definir los controles
        ilClinNombres = findViewById<TextInputLayout>(R.id.ilClinNombres)
        ilClinApellidos = findViewById<TextInputLayout>(R.id.ilClinApellidos)
        ilClinTelefono = findViewById<TextInputLayout>(R.id.ilClinTelefono)
        ilClinCorreo = findViewById<TextInputLayout>(R.id.ilClinCorreo)
        ilClinObserv = findViewById<TextInputLayout>(R.id.ilClinObserv)

        etClinNombres = findViewById<EditText>(R.id.etClinNombres)
        etClinApellidos = findViewById<EditText>(R.id.etClinApellidos)
        etClinTelefono = findViewById<EditText>(R.id.etClinTelefono)
        etClinCorreo = findViewById<EditText>(R.id.etClinCorreo)
        etClinObserv = findViewById<EditText>(R.id.etClinObserv)

        btnClinSiguiente = findViewById<Button>(R.id.btnClinSiguiente)


        btnClinSiguiente.setOnClickListener {
            validarFormulario()

            //val intent = Intent(this, ServicioActivity::class.java)
            //startActivity(intent)
        }

    }

    fun validarFormulario() {
        val clinNombres = etClinNombres.text.toString().trim()
        val clinApellidos = etClinApellidos.text.toString().trim()
        val clinTelefono = etClinTelefono.text.toString().trim()
        val clinCorreo = etClinCorreo.text.toString().trim()
        val clinObserv = etClinObserv.text.toString().trim()

        ilClinNombres.error = null
        ilClinApellidos.error = null
        ilClinTelefono.error = null
        ilClinCorreo.error = null
        ilClinObserv.error = null

        var esValido = true

        if (clinNombres.isEmpty()) {
            ilClinNombres.error = "Campo obligatorio"
            esValido = false
        }
        if (clinApellidos.isEmpty()) {
            ilClinApellidos.error = "Campo obligatorio"
            esValido = false
        }
        if (clinTelefono.isEmpty()) {
            ilClinTelefono.error = "Campo obligatorio"
            esValido = false
        }
        if (clinCorreo.isEmpty() || !clinCorreo.contains("@")) {
            ilClinCorreo.error = "Correo inválido"
            esValido = false
        }
    }

}