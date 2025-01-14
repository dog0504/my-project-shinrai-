package com.akapp.shinrai_v2

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Grid
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.google.android.flexbox.FlexboxLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterHobbyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterHobbyFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_hobby, container, false)
    }

    //画面遷移処理
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //エディットテキスト入力ボックス
        val editText = view.findViewById<EditText>(R.id.edit_lover_hobby)

        // ボタンを追加するコンテナを取得
        val buttonListContainer = view.findViewById<GridLayout>(R.id.hobby_list_button_container)

        buttonListContainer.columnCount = 3

        //　FragmentMangerの取得
        val rhf = parentFragmentManager

        //　トランザクションの生成・コミット
        val fm = rhf.beginTransaction()

        //　必要な要素をActivityから取得
        val frontButton = requireActivity().findViewById<Button>(R.id.front)
        val nextButton = requireActivity().findViewById<Button>(R.id.next)


        editText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || // 「完了」ボタンの場合
                (event != null && event.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER)) { // エンターキーの場合

                val inputText = editText.text.toString()

                if (inputText.isNotEmpty()) {
                    val newButton = Button(requireContext())
                    newButton.text = inputText

                    newButton.textSize = 16f
                    newButton.setTextColor(Color.parseColor("#000000"))
                    newButton.setBackgroundResource(R.drawable.bt_gender_selection)

                    val params = GridLayout.LayoutParams(
                        GridLayout.spec(GridLayout.UNDEFINED, 1f),
                        GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    ).apply {
                        width = GridLayout.LayoutParams.MATCH_PARENT
                        height = GridLayout.LayoutParams.WRAP_CONTENT

                        setMargins(20,10,20,10)

                        newButton.gravity = android.view.Gravity.CENTER //ボタンを自体を中央に揃える
                    }
                    buttonListContainer.addView(newButton, params)

//                    newButton.setOnClickListener {
//                        android.widget.Toast.makeText(this, "ボタン「$inputText」が押されました", android.widget.Toast.LENGTH_SHORT).show()
//                    }

                    // EditTextの内容をクリア
                    editText.text.clear()

                    return@OnEditorActionListener true // イベントを処理したことを示す
                } else {
//                    android.widget.Toast.makeText(this, "テキストを入力してください", android.widget.Toast.LENGTH_SHORT).show()
                }
            }
            false // イベントを処理しなかったことを示す
        })





        frontButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterMbtiFragment())
                commit()
            }
        }

        nextButton.setOnClickListener {
            fm.apply {
                replace(R.id.fragmentContainerView, RegisterConfirmFragment())
                commit()
            }
        }



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterHobbyFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterHobbyFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}