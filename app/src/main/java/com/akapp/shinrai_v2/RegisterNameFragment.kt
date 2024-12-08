package com.akapp.shinrai_v2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterNameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterNameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate( savedInstanceState: Bundle?) {
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
        return inflater.inflate(R.layout.fragment_register_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //FragmentMangerの取得
        val rnfm = parentFragmentManager
        //トランザクションの生成・コミット
        val ft = rnfm.beginTransaction()

        // register.xmlにあるnextボタンを呼び出す
        //val next = view.findViewById<Button>(R.id.next)
        // フラグメントからアクティビティ側のビューにアクセスするには、
        // requireActivity()を介してアクティビティのコンテキストを取得し、findViewById()を行う
        val frontButton = requireActivity().findViewById<Button>(R.id.front)
        val nextButton = requireActivity().findViewById<Button>(R.id.next)

        frontButton.setOnClickListener {
            // RegisterActivityの画面からMainActivityの画面に遷移
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        nextButton.setOnClickListener{
            ft.apply {
                replace(R.id.fragmentContainerView, RegisterGenderFragment())
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
         * @return A new instance of fragment RegisterNameFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterNameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}