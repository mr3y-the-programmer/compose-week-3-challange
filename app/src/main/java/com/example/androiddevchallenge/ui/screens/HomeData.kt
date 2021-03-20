/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import com.example.androiddevchallenge.R

data class Position(
    val nickName: String,
    val name: String,
    val drawableId: Int,
    val balance: String,
    val percentage: String
)

val chips = listOf("Week", "ETFs", "Stocks", "Funds", "Other")

val positions = listOf(
    Position(
        nickName = "ALK",
        name = "Alaska Air Group, Inc",
        drawableId = R.drawable.position_placeholder,
        balance = "$7,918",
        percentage = "-0.54%"
    ),
    Position(
        nickName = "BA",
        name = "Boeing Co.",
        drawableId = R.drawable.position_placeholder,
        balance = "$1,293",
        percentage = "+4.18%"
    ),
    Position(
        nickName = "DAL",
        name = "Delta Airlines Inc.",
        drawableId = R.drawable.position_placeholder,
        balance = "$893.50",
        percentage = "-0.54%"
    ),
    Position(
        nickName = "EXPE",
        name = "Expedia Group Inc.",
        drawableId = R.drawable.position_placeholder,
        balance = "$12,301",
        percentage = "+2.51%"
    ),
    Position(
        nickName = "EADSY",
        name = "Airbus SE",
        drawableId = R.drawable.position_placeholder,
        balance = "$12,301",
        percentage = "+1.38%"
    ),
    Position(
        nickName = "JBLU",
        name = "Jetblue Airways Corp.",
        drawableId = R.drawable.position_placeholder,
        balance = "$8,521",
        percentage = "+1.56%"
    ),
    Position(
        nickName = "MAR",
        name = "Marriott International Inc.",
        drawableId = R.drawable.position_placeholder,
        balance = "$521",
        percentage = "+2.75%"
    ),
    Position(
        nickName = "CCL",
        name = "Carnival Corp",
        drawableId = R.drawable.position_placeholder,
        balance = "$5,481",
        percentage = "+0.14%"
    ),
    Position(
        nickName = "RCL",
        name = "Royal Caribbean Cruises",
        drawableId = R.drawable.position_placeholder,
        balance = "$9,184",
        percentage = "+1.69%"
    ),
    Position(
        nickName = "TRVL",
        name = "Travelocity Inc.",
        drawableId = R.drawable.position_placeholder,
        balance = "$654",
        percentage = "+3.23%"
    ),
)
