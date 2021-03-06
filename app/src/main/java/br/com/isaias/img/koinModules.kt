package br.com.isaias.img

import br.com.isaias.img.data.data_source.PhotoDataSource
import br.com.isaias.img.data.data_source.UserDataSource
import br.com.isaias.img.data.repository.PhotoRepository
import br.com.isaias.img.data.repository.UserRepository
import br.com.isaias.img.data.service.UserService
import br.com.isaias.img.ui.login.LoginViewModel
import br.com.isaias.img.ui.photos.PhotosViewModel
import br.com.isaias.img.ui.signup.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    //repository and datasource
    single<UserRepository> { UserDataSource(get()) }
    single<PhotoRepository> { PhotoDataSource() }

    //services
    single { UserService.getInstance() }
}

val viewModelModules = module {
    viewModel { LoginViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { PhotosViewModel(get()) }
}
