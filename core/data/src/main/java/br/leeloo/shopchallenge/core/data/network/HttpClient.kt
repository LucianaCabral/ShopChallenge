package br.leeloo.shopchallenge.core.data.network

interface HttpClient {
    fun <T> create(clazz: Class<T>): T
}