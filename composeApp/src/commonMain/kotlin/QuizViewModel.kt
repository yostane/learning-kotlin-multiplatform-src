import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import network.QuizRepository
import app.cash.sqldelight.db.SqlDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import network.data.Question


class QuizViewModel(sqlDriver:SqlDriver) : ViewModel() {
    private var quizRepository: QuizRepository=QuizRepository(sqlDriver)
    private var _questionState=  MutableStateFlow(listOf<Question>())
    var questionState:StateFlow<List<Question>> = _questionState
    
    /* Explicit backing field 
    val questionState : StateFlow<List<Question>>
       field =  MutableStateFlow(listOf<Question>())
    in build.gradle.kts
    sourceSets.all {
        languageSettings.enableLanguageFeature("ExplicitBackingFields")
    }
    */
    
    init {
        getQuestionQuiz()
    }
    
    private fun getQuestionQuiz(){

        viewModelScope.launch(Dispatchers.Default) {
            _questionState.update {
               quizRepository.updateQuiz()
            }
        }
    }
    
    

    
}