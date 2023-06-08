package io.github.tuguzd.gamegenbulb.view.screen.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo
import io.github.tuguzd.gamegenbulb.R
import io.github.tuguzd.gamegenbulb.domain.model.system.user.data.UserCredentials
import io.github.tuguzd.gamegenbulb.view.screen.NavGraphs
import io.github.tuguzd.gamegenbulb.view.screen.destinations.LoginScreenDestination
import io.github.tuguzd.gamegenbulb.view.util.collectInLaunchedEffectWithLifecycle
import io.github.tuguzd.gamegenbulb.view.util.field.OneLineTextField
import io.github.tuguzd.gamegenbulb.view.util.field.PasswordTextField
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up.SignUpViewModel
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up.store.SignUpStore.Intent
import io.github.tuguzd.gamegenbulb.viewmodel.auth.sign_up.store.SignUpStore.Label

@AuthNavGraph
@Destination
@Composable
fun RegisterScreen(
    navigator: DestinationsNavigator,
    viewModel: SignUpViewModel,
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

    val state by viewModel.stateFlow.collectAsStateWithLifecycle()
    viewModel.labels.collectInLaunchedEffectWithLifecycle block@{ label ->
        val message = when (label) {
            Label.LocalStoreError -> context.getString(R.string.local_store_error)
            Label.NetworkAccessError -> context.getString(R.string.network_access_error)
            Label.UnknownError -> context.getString(R.string.unknown_error)
            is Label.NameAlreadyTaken -> context.getString(
                R.string.user_with_name_already_exists,
                label.name,
            )
        }
        snackBarHostState.showSnackbar(
            message = message,
            actionLabel = context.getString(R.string.dismiss),
        )
    }

    AuthContent(
        title = stringResource(R.string.create_new_account),
        submitText = stringResource(R.string.register),
        onSubmit = {
            val credentials = UserCredentials(state.name, state.password)
            val intent = Intent.SignUp(credentials)
            viewModel.accept(intent)
        },
        submitEnabled = state.valid,
        loading = state.loading,
        changeAuthTypeText = stringResource(R.string.already_have_an_account),
        changeAuthTypeClickableText = stringResource(R.string.login),
        onChangeAuthType = {
            val direction = LoginScreenDestination()
            navigator.navigate(direction) {
                popUpTo(NavGraphs.auth) { inclusive = true }
            }
        },
        snackBarHostState = snackBarHostState,
    ) {
        OneLineTextField(
            modifier = Modifier.fillMaxWidth(),
            input = state.name,
            onInputChange = { input ->
                val intent = Intent.ChangeName(input)
                viewModel.accept(intent)
            },
            enabled = !state.loading,
            label = stringResource(R.string.user_name),
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            input = state.password,
            onInputChange = { password ->
                val intent = Intent.ChangePassword(password)
                viewModel.accept(intent)
            },
            inputVisible = state.passwordVisible,
            onInputVisibleChange = { passwordVisible ->
                val intent = Intent.ChangePasswordVisible(passwordVisible)
                viewModel.accept(intent)
            },
            enabled = !state.loading,
        )
        Spacer(modifier = Modifier.height(16.dp))
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            input = state.repeatPassword,
            onInputChange = { repeatPassword ->
                val intent = Intent.ChangeRepeatPassword(repeatPassword)
                viewModel.accept(intent)
            },
            label = stringResource(R.string.repeat_password),
            inputVisible = state.passwordVisible,
            onInputVisibleChange = { passwordVisible ->
                val intent = Intent.ChangePasswordVisible(passwordVisible)
                viewModel.accept(intent)
            },
            trailingIconVisible = false,
            enabled = !state.loading,
        )
    }
}
