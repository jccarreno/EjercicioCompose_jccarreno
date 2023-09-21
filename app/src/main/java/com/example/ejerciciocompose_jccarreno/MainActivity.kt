package com.example.ejerciciocompose_jccarreno

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejerciciocompose_jccarreno.ui.theme.EjercicioCompose_jccarrenoTheme

data class Persona(val imagen:Int,val nombre:String, val titulo:String, val celular:String, val empresa:String, val correo:String)
val colModifier= Modifier
    .fillMaxSize()
    .padding(16.dp)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjercicioCompose_jccarrenoTheme{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(android.graphics.Color.parseColor("#D6EAF8")))
                ) {
                    Disposicion()
                }
            }
        }
    }
}

@Composable
fun Disposicion(){
    val persona=Persona(R.drawable.profile_picture,"Juan Camilo Carreño","Ingeniero de Sistemas","+57 3184919102","Universidad del Cauca","jccarreno@unicauca.edu.co")
    Column(modifier=colModifier, horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(100.dp))
        Presentacion(persona = persona)
        Spacer(modifier = Modifier.height(200.dp))
        Contacto(persona = persona)
    }
}

@Composable
fun Presentacion(persona:Persona){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(persona.imagen),
            contentDescription = "",
            modifier = Modifier
                // Set image size to 40 dp
                .size(200.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        Text(persona.nombre,fontSize = 30.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)
        Text(persona.titulo,fontSize = 20.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal)
    }
}

@Composable
fun Contacto(persona:Persona){
    Column(){
        TextoImagen(R.drawable.whatsapp,persona.celular)
        TextoImagen(R.drawable.edificio,persona.empresa)
        TextoImagen(R.drawable.correo,persona.correo)
    }
}

@Composable
fun TextoImagen(imagen:Int, texto:String){
    Spacer(modifier = Modifier.height(5.dp))
    Row{
        Image(
            painter = painterResource(imagen),
            contentDescription = "",
            modifier = Modifier
                // Set image size to 40 dp
                .size(30.dp)
                // Clip image to be shaped as a circle
        )
        Box(modifier = Modifier.width(16.dp).height(0.dp).background(MaterialTheme.colorScheme.primary))
        Text(texto,fontSize = 18.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Italic)
    }
}