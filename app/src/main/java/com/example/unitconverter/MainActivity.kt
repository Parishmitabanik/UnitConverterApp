package com.example.unitconverter

//import android.R

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import kotlin.Boolean
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)

                {
                   UnitConverter()

                }
            }
        }
    }
}


@Composable
fun UnitConverter(){

    var inputValue by remember {
        mutableStateOf(value = "")
    }
    var outputValue by remember {
        mutableStateOf(value = "")
    }
    var inputUnit by remember {

        mutableStateOf(value = "Metres")
    }
    var outputUnit by remember {
            mutableStateOf(value = "Metres")

    }
    var iExpanded by remember {
        mutableStateOf(value = false)
    }
    var oExpanded by remember {
        mutableStateOf(value = false)
    }
    val conversion = remember {
        mutableStateOf(value = 1.00)
    }
    val oconversion = remember {
        mutableStateOf(value = 1.00)
    }


    fun convertUnits(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversion.value * 100.0 / oconversion.value).roundToInt() / 100.0
        outputValue = result.toString()
    }


    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
        //Spacer(modifier = Modifier.height(16))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
            convertUnits()

            //Here goes
        },
            label = {Text(text = "Enter value")})

        Row {
            Box {
                    Button(onClick = { iExpanded = true }) {
                        Text(text = inputUnit)
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Down"
                        )

                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false })
                {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Centimeters"
                        conversion.value = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Meters"
                        conversion.value = 1.0
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        iExpanded = false
                        inputUnit = "Millimeters"
                        conversion.value = 0.001
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        iExpanded = false
                        inputUnit = "Feet"
                        conversion.value = 0.3048
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Inches") }, onClick = {
                        iExpanded = false
                        inputUnit = "Inches"
                        conversion.value = 0.0254
                        convertUnits()
                    })

                    DropdownMenuItem(text = { Text(text = "Kilometers") }, onClick = {
                        iExpanded = false
                        inputUnit = "Kilometers"
                        conversion.value = 1000.0
                        convertUnits()
                    })

                    DropdownMenuItem(text = { Text(text = "Yards") }, onClick = {
                        iExpanded = false
                        inputUnit = "Yards"
                        conversion.value = 0.9144
                        convertUnits()
                    })

                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                    Button(onClick = { oExpanded = true }) {
                        Text(text = outputUnit)
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Down"
                        )
                    }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false })
                {
                    DropdownMenuItem(text = { Text(text = "Centimeters") }, onClick = {
                        oExpanded = false
                        outputUnit = "Centimeters"
                        oconversion.value = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters") }, onClick = {
                        oExpanded = false
                        outputUnit = "Meters"
                        oconversion.value = 1.0
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters") }, onClick = {
                        oExpanded = false
                        outputUnit = "Millimeters"
                        oconversion.value = 0.001
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet") }, onClick = {
                        oExpanded = false
                        outputUnit = "Feet"
                        oconversion.value = 0.3048
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Inches") }, onClick = {
                        oExpanded = false
                        outputUnit = "Inches"
                        oconversion.value = 0.0254
                        convertUnits()
                    })

                    DropdownMenuItem(text = { Text(text = "Kilometers") }, onClick = {
                        oExpanded = false
                        outputUnit = "Kilometers"
                        oconversion.value = 1000.0
                        convertUnits()
                    })

                    DropdownMenuItem(text = { Text(text = "Yards") }, onClick = {
                        oExpanded = false
                        outputUnit = "Yards"
                        oconversion.value = 0.9144
                        convertUnits()
                    })
                }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Result: $outputValue $outputUnit",
                style = MaterialTheme.typography.headlineMedium)
        }

}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}
