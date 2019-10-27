package com.sha.kamel.sample.model

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel
data class Message @ParcelConstructor constructor(var message: String)
