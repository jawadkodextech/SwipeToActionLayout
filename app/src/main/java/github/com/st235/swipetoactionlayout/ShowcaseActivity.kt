package github.com.st235.swipetoactionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import github.com.st235.lib_swipetoactionlayout.SwipeAction
import github.com.st235.lib_swipetoactionlayout.SwipeToActionLayout
import github.com.st235.swipetoactionlayout.databinding.ActivityShowcaseBinding

class ShowcaseActivity : AppCompatActivity() {
    private lateinit var binding:ActivityShowcaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowcaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.swipeToActionLayout.actions =
            listOf(
                SwipeAction.withBackgroundColor(
                    actionId = R.id.action_call,
                    iconId = R.drawable.ic_call_black_18dp,
                    text = "Call",
                    backgroundColor = 0xFF455A64.toInt()
                ),
                SwipeAction.withBackgroundColor(
                    actionId = R.id.action_email,
                    iconId = R.drawable.ic_email_black_18dp,
                    text = "Email",
                    backgroundColor = 0xFF37474F.toInt()
                ),
                SwipeAction.withBackgroundColor(
                    actionId = R.id.action_delete,
                    iconId = R.drawable.ic_delete_black_18dp,
                    text = "Remove",
                    iconTint = 0xFFEEEEEE.toInt(),
                    textColor = 0xFFEEEEEE.toInt(),
                    backgroundColor = 0xFF263238.toInt()
                )
            )

        binding.vibrateCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.tag
            binding.swipeToActionLayout.shouldVibrateOnQuickAction = isChecked
        }

        binding.quickActionCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            buttonView.tag
            binding.swipeToActionLayout.isFullActionSupported = isChecked
        }

        binding.left.setOnClickListener {
            binding.swipeToActionLayout.gravity = SwipeToActionLayout.MenuGravity.LEFT
        }

        binding.right.setOnClickListener {
            binding.swipeToActionLayout.gravity = SwipeToActionLayout.MenuGravity.RIGHT
        }

        binding.start.setOnClickListener {
            binding.swipeToActionLayout.gravity = SwipeToActionLayout.MenuGravity.START
        }

        binding.end.setOnClickListener {
            binding.swipeToActionLayout.gravity = SwipeToActionLayout.MenuGravity.END
        }

        binding.open.setOnClickListener {
            binding.swipeToActionLayout.open()
        }

        binding.close.setOnClickListener {
            binding.swipeToActionLayout.close()
        }

        binding.openFully.setOnClickListener {
            binding.swipeToActionLayout.fullyOpen()
        }
    }
}