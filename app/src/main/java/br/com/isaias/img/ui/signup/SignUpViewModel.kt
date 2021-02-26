package br.com.isaias.img.ui.signup

import android.util.Patterns
import androidx.lifecycle.*
import br.com.isaias.img.R
import br.com.isaias.img.data.model.User
import br.com.isaias.img.data.repository.UserRepository
import br.com.isaias.img.value_obj.Resource
import br.com.isaias.img.value_obj.Result
import kotlinx.coroutines.launch

class SignUpViewModel(private val userRepository: UserRepository) : ViewModel() {


    val name = MutableLiveData<String>()

    val lastName = MutableLiveData<String>()

    val username = MutableLiveData<String>()
    private val _usernameError = MutableLiveData<Int>()
    val usernameError : LiveData<Int> =  _usernameError

    val email = MutableLiveData<String>()
    private val _emailError = MutableLiveData<Int>()
    val emailError : LiveData<Int> =  _emailError

    val birthDate = MutableLiveData<String>()

    val password = MutableLiveData<String>()
    private val _passwordError = MutableLiveData<Int>()
    val passwordError: LiveData<Int> = _passwordError

    val confirmPassword = MutableLiveData<String>()

    val isTermsAccpted = MutableLiveData(false)

    private val _areFieldsFilled = MutableLiveData<Boolean>()
    val areFieldsFilled : LiveData<Boolean> = _areFieldsFilled

    private val _userCreated = MutableLiveData<Resource<User>>()
    val userCreated : LiveData<Resource<User>> = _userCreated

    private val fieldsObserver = Observer<Any>{validateFields()}

    init {
        name.observeForever(fieldsObserver)
        lastName.observeForever(fieldsObserver)
        username.observeForever(fieldsObserver)
        email.observeForever(fieldsObserver)
        birthDate.observeForever(fieldsObserver)
        password.observeForever(fieldsObserver)
        confirmPassword.observeForever(fieldsObserver)
        isTermsAccpted.observeForever(fieldsObserver)
    }

    private fun validateFields() {
        val isValid = !email.value.isNullOrBlank()
                && !birthDate.value.isNullOrBlank()
                && !name.value.isNullOrBlank()
                && !lastName.value.isNullOrBlank()
                && !username.value.isNullOrBlank()
                && !confirmPassword.value.isNullOrBlank()
                && !password.value.isNullOrBlank()
                && (isTermsAccpted.value ?: false)
        _areFieldsFilled.postValue(isValid)
    }


    fun signUp(){
        if (!hasError){
            _userCreated.value = Resource.loading()
            val createdUser = instantiateUser()

            viewModelScope.launch {
                val result = userRepository.signUp(createdUser)
                if (result is Result.Success) _userCreated.value = Resource.success(result.data)
                if (result is Result.Error) _userCreated.value = Resource.error(result.exception)
            }
        }
    }

    private fun instantiateUser(): User = User(
        firstName = name.value ?: "",
        lastName = lastName.value ?: "",
        username = username.value ?: "",
        email = email.value ?: "",
        birthDate = birthDate.value ?: "",
        password = password.value ?: ""
    )

    val hasError: Boolean
        get() {
            _usernameError.value = if (username.value?.length?.compareTo(8) == -1)
                R.string.singUp_error_username_invalid
            else
                null
            _emailError.value = if  (!(Patterns.EMAIL_ADDRESS.matcher(email.value).matches()))
                R.string.signUp_error_email_is_not_a_email
            else
                null
            _passwordError.value = if (confirmPassword.value != password.value)
                R.string.sign_up_confirm_password_error_message
            else
                null

            return _passwordError.value != null || _usernameError.value != null || _emailError.value != null
        }

    override fun onCleared() {
        super.onCleared()
        name.removeObserver(fieldsObserver)
        lastName.removeObserver(fieldsObserver)
        username.removeObserver(fieldsObserver)
        email.removeObserver(fieldsObserver)
        birthDate.removeObserver(fieldsObserver)
        password.removeObserver(fieldsObserver)
        confirmPassword.removeObserver(fieldsObserver)
    }
}