package ui.dendi.simplereduxmvipattern.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.siddroid.holi.colors.CoolColor
import ui.dendi.simplereduxmvipattern.R
import ui.dendi.simplereduxmvipattern.RandomColor
import ui.dendi.simplereduxmvipattern.domain.model.Number
import ui.dendi.simplereduxmvipattern.presentation.theme.Eczar

@Composable
fun NumbersScreen(
    modifier: Modifier = Modifier,
    viewModel: NumbersViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState().value
    var showNumbers by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.wrapContentSize().align(Alignment.Center), color = Color.Black
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom
        ) {
            if (showNumbers) {
                LazyColumn(
                    modifier = Modifier.padding(start = 16.dp).weight(1f).fillMaxSize(),
                ) {
                    items(items = state.numbersList, key = { it.id }) { number ->
                        NumberItem(number = number)
                    }
                }
            }

            ButtonSection(viewModel = viewModel, showNumbers = showNumbers) { showNumbers = true }
        }
    }
}

@Composable
private fun ButtonSection(viewModel: NumbersViewModel, showNumbers: Boolean, onClick: () -> Unit) {

    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                onClick()
                viewModel.getNumbers()
            },
            modifier = Modifier.padding(end = 8.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = CoolColor.DARK_BLUE,
                backgroundColor = CoolColor.WHITE,
            )
        ) {
            Text(
                text = stringResource(R.string.show_numbers),
                fontFamily = Eczar,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
        }

        if (showNumbers) {
            Button(
                onClick = { viewModel.shuffleNumbers() },
                modifier = Modifier.padding(start = 8.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = CoolColor.DARK_BLUE,
                    backgroundColor = CoolColor.WHITE,
                )
            ) {
                Text(
                    text = stringResource(R.string.shuffle_numbers),
                    fontFamily = Eczar,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
private fun NumberItem(number: Number) {
    val annotatedString = buildAnnotatedString {
        val item = number.number.toString().split(".")
        val before = item[0]
        val after = item[1]

        withStyle(
            style = SpanStyle(
                fontSize = 18.sp,
                fontFamily = Eczar,
                fontWeight = FontWeight.Medium,
                color = RandomColor.colors.random(),
            )
        ) {
            append("${number.id}) ")
        }

        withStyle(
            style = SpanStyle(
                fontSize = 48.sp,
                fontFamily = Eczar,
                fontWeight = FontWeight.Bold,
                color = RandomColor.colors.random(),
            )
        ) {
            append("$before.")
        }
        withStyle(
            style = SpanStyle(
                fontSize = 24.sp,
                fontFamily = Eczar,
                fontWeight = FontWeight.Medium,
                color = RandomColor.colors.random(),
            )
        ) {
            append(after)
        }
    }
    Text(
        text = annotatedString, modifier = Modifier.padding(start = 8.dp).fillMaxWidth()
    )
}