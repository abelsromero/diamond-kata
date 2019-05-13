package org.abelsromero.diamond

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.Test

class DiamondTest {

    @Test
    fun should_create_diamonds_of_size_0() {
        // given
        val diamond = Diamond(0)
        // when
        val result: String = diamond.build()
        // then
        assertThat(result).isEqualTo("")
    }

    @Test
    fun should_create_diamonds_of_size_1() {
        // given
        val diamond = Diamond(1)
        // when
        val result = diamond.build()
        // then
        assertThat(result).isEqualTo("*")
    }

    @Test
    fun should_fail_create_diamonds_of_size_2() {
        // when
        val e = catchThrowable { Diamond(2) }

        // then
        assertThat(e)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Size must be odd number")
    }

    @Test
    fun should_fail_create_diamonds_of_negative() {
        // when
        val e = catchThrowable { Diamond(-3) }

        // then
        assertThat(e)
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Size must be odd positive number")
    }

    @Test
    fun should_create_diamonds_of_size_5() {
        // given
        val diamond = Diamond(5)
        // when
        val result = diamond.build()
        // then
        assertThat(result).isEqualTo("""
            |__*__
            |_*_*_
            |*___*
            |_*_*_
            |__*__
        """.trimMargin())
    }

    @Test
    fun should_create_diamonds_of_size_9() {
        // given
        val diamond = Diamond(9)
        // when
        val result = diamond.build()
        // then
        assertThat(result).isEqualTo("""
            |____*____
            |___*_*___
            |__*___*__
            |_*_____*_
            |*_______*
            |_*_____*_
            |__*___*__
            |___*_*___
            |____*____
        """.trimMargin())
    }

    @Test
    fun should_create_diamonds_of_size_7() {
        // given
        val diamond = Diamond(7)
        // when
        val result = diamond.build()
        // then
        assertThat(result).isEqualTo("""
            |___*___
            |__*_*__
            |_*___*_
            |*_____*
            |_*___*_
            |__*_*__
            |___*___
        """.trimMargin())
    }

}