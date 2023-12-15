package mobi.appcent.statesexample.ui

/**
 * Created by Furkan Yurdakul on 14.12.2023.
 */
object Routes {
    const val HOME = "home"
    const val LOCAL_STATE = "local_state"

    object LocalState {
        const val HOME = "local_state.home"
        const val MUTABLE_STATE = "local_state.mutable_state"
        const val DELEGATED_STATE = "local_state.delegated_state"
        const val MUTABLE_STATE_WITH_LAMBDA = "local_state.mutable_state_with_lambda"
        const val DELEGATED_STATE_WITH_LAMBDA = "local_state.delegated_state_with_lambda"
        const val MUTABLE_STATE_INLINE = "local_state.mutable_state_inline"
        const val DELEGATED_STATE_INLINE = "local_state.delegated_state_inline"
    }
}