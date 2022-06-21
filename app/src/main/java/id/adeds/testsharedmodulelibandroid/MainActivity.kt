package id.adeds.testsharedmodulelibandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import id.adeds.sharedmodulekmmlibs.model.CharacterUiModel
import id.adeds.testsharedmodulelibandroid.ui.theme.TestSharedModuleLibAndroidTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestSharedModuleLibAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(mainViewModel.characters.observeAsState(), mainViewModel.error.observeAsState())
                }
            }
        }

        mainViewModel.getCharacter()
    }
}

@Composable
fun Greeting(list: State<List<CharacterUiModel>?>, error: State<String?>) {
    list.value?.let {
        Text(modifier = Modifier.fillMaxSize(), text = "data: $it")
    }

    error.value?.let {
        Text(text = "error: $it")
    }

}