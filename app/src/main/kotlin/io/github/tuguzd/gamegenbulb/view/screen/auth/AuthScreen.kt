package io.github.tuguzd.gamegenbulb.view.screen.auth

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.dependency
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_in.SignInViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up.SignUpViewModel

@RootNavGraph
@Destination
@Composable
fun AuthScreen(
    signInViewModel: SignInViewModel = hiltViewModel(),
    signUpViewModel: SignUpViewModel = hiltViewModel(),
) = DestinationsNavHost(
    navGraph = NavGraphs.auth,
    dependenciesContainerBuilder = {
        dependency(signInViewModel)
        dependency(signUpViewModel)
    },
)
