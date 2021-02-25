package br.com.isaias.img.ui.login

import androidx.lifecycle.*
import br.com.isaias.img.data.model.User
import br.com.isaias.img.data.repository.UserRepository
import br.com.isaias.img.value_obj.Resource
import br.com.isaias.img.value_obj.Result
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    val email = MutableLiveData<String>()
//    private val _emailError = MutableLiveData<Int>()
//    val emailError : LiveData<Int> = _emailError

    val password = MutableLiveData<String>()
//    private val _passwordError = MutableLiveData<Int>()
//    val passwordError : LiveData<Int> = _passwordError

    private val _areFieldsFilled = MutableLiveData<Boolean>()
    val areFieldsFilled : LiveData<Boolean> = _areFieldsFilled

    private val _loggedUser = MutableLiveData<Resource<User>>()
    val loggedUser : LiveData<Resource<User>> = _loggedUser

    private val fieldsObserver = Observer<String>{validateFields()}

    init {
        email.observeForever(fieldsObserver)
        password.observeForever(fieldsObserver)
    }

    private fun validateFields() {
        val isValid = !email.value.isNullOrBlank()
                && !password.value.isNullOrBlank()
        _areFieldsFilled.postValue(isValid)
    }

    fun login(){
        viewModelScope.launch {
            _loggedUser.value = Resource.loading()
            val result = userRepository.login()
            if (result is Result.Success) _loggedUser.value = Resource.success(result.data)
            if (result is Result.Error) _loggedUser.value = Resource.error(result.exception)
        }
    }

    override fun onCleared() {
        super.onCleared()
        email.removeObserver(fieldsObserver)
        password.removeObserver(fieldsObserver)
    }
}