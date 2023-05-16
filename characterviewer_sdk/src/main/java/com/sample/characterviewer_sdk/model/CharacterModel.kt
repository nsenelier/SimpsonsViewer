package com.sample.characterviewer_sdk.model


import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("RelatedTopics")
    val relatedTopics: List<RelatedTopic>?=null,

)

data class RelatedTopic(
    @SerializedName("FirstURL")
    var firstURL: String?=null,
    @SerializedName("Icon")
    val icon: Icon?=null,
    @SerializedName("Result")
    val result: String?=null,
    @SerializedName("Text")
    val text: String?=null
)

data class Icon(
    @SerializedName("Height")
    val height: String?=null,
    @SerializedName("URL")
    val uRL: String?=null,
    @SerializedName("Width")
    val width: String?=null
)