package com.example.composerickandmorty.ui.data.repository

import com.example.composerickandmorty.ui.data.model.characters.ResultModel
import com.example.composerickandmorty.ui.data.remote.FakeApiRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RepositoryImplTest {
    private lateinit var repository: RepositoryImpl
    private lateinit var fakeApiRequest: FakeApiRequest

    @Before
    fun setUp() {
        fakeApiRequest = FakeApiRequest()
        repository = RepositoryImpl(fakeApiRequest)
    }



    @Test
    fun testgetCharacters() = runBlocking {
        val expectedCartoonCharsList = listOf(
            ResultModel(id =1, name = " Rick Sanchez", status = "Alive"),
            ResultModel(id =2, name = " Morty Smith", status = "Alive"),
            ResultModel(id =3, name = " Summer Smith", status = "Alive"),
        )
        fakeApiRequest.setMockedResponse(expectedCartoonCharsList)

        val actualCartoonChars = repository.getCharacters()

        assertThat(actualCartoonChars).isEqualTo(expectedCartoonCharsList)
    }

    @Test
    fun testgetApiRequest_nullResult() = runBlocking {
        val expectedCartoonChars = emptyList<ResultModel>()
        fakeApiRequest.setMockedResponse(expectedCartoonChars)
        val actualCartoonChars = repository.getCharacters()
        assertThat(actualCartoonChars).isNull()
    }

    @Test
    fun testgetApiRequest_emptyResult() = runBlocking {
        val expectedCartoonChars = emptyList<ResultModel>()
        fakeApiRequest.setMockedResponse(expectedCartoonChars)
        val actualCartoonChars = repository.getCharacters()
        assertThat(actualCartoonChars.results).isEmpty()
    }



}