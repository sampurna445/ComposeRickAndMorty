package com.example.composerickandmorty.ui.characters


import com.example.composerickandmorty.data.model.characters.CharactersModel
import com.example.composerickandmorty.data.repository.FakeRepository
import com.example.composerickandmorty.data.model.characters.ResultModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test
import org.mockito.Mockito

class CartoonCharactersViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var fakeRepository: FakeRepository
    private lateinit var viewModel: CartoonCharactersViewModel



    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeRepository()
        viewModel = CartoonCharactersViewModel(fakeRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetCharacters() = runTest {
        val characters = CharactersModel()


        // Return the mock CharctersModel object from the repository
        Mockito.`when`(fakeRepository.getCharacters()).thenReturn(characters)

        val viewModel = CartoonCharactersViewModel(fakeRepository)
        viewModel.getCharacters()

        // Calling the function that uses the repository to get the characters

        testDispatcher.scheduler.advanceUntilIdle()

        // Checking if the cartoon chars LiveData contains the expected result
        viewModel.cartoonChars.value?.let { value ->
            assertEquals(0, value.size ?: 0)
        }

    }
}