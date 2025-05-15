package tasks.adts

import org.junit.*
import org.junit.Assert.*
import tasks.adts.SchoolModel.*
import u03.extensionmethods.Optionals.*
import u03.extensionmethods.Sequences.*
import u03.extensionmethods.Sequences.Sequence.*

class SchoolModelTest:
  val schoolModel: SchoolModule = BasicSchoolModule
  import BasicSchoolModule.*

  @Test def testSetTeacherToCourse() : Unit =
    val school = emptySchool
    assertEquals(Nil(), school)
    val john = teacher("John")
    val math = course("Math")
    val school2 = school.setTeacherToCourse(john, math)
    assertEquals(Cons(("John", "Math"), Nil()), school2)

  @Test def testCourses(): Unit =
    val john = teacher("John")
    val tyler = teacher("Tyler")
    val math = course("Math")
    val history = course("History")
    val school = emptySchool.setTeacherToCourse(john, math)
      .setTeacherToCourse(tyler, math)
      .setTeacherToCourse(john, history)
    assertEquals(Cons("Math", Cons("History", Nil())), school.courses)

  @Test def testTeachers(): Unit =
    val john = teacher("John")
    val tyler = teacher("Tyler")
    val math = course("Math")
    val history = course("History")
    val school = emptySchool.setTeacherToCourse(john, math)
      .setTeacherToCourse(tyler, math)
      .setTeacherToCourse(john, history)
    assertEquals(Cons("John", Cons("Tyler", Nil())), school.teachers)

  @Test def testCoursesOfATeacher(): Unit =
    val john = teacher("John")
    val tyler = teacher("Tyler")
    val math = course("Math")
    val history = course("History")
    val school = emptySchool.setTeacherToCourse(john, math)
      .setTeacherToCourse(john, history)
    assertEquals(Cons("Math", Cons("History", Nil())), school.coursesOfATeacher(john))
    assertEquals(Nil(), school.coursesOfATeacher(tyler))

  @Test def testHasTeacher(): Unit =
    val john = teacher("John")
    val tyler = teacher("Tyler")
    val math = course("Math")
    val history = course("History")
    val school = emptySchool.setTeacherToCourse(john, math)
    assertTrue(school.hasTeacher(john))
    assertFalse(school.hasTeacher(tyler))

  @Test def testHasCourse(): Unit =
    val john = teacher("John")
    val tyler = teacher("Tyler")
    val math = course("Math")
    val history = course("History")
    val school = emptySchool.setTeacherToCourse(john, math)
    assertTrue(school.hasCourse(math))
    assertFalse(school.hasCourse(history))
