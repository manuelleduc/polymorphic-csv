package polymorphic.tests.lib

import java.io.IOException
import java.util.Map
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.junit.Assert

class PolymorphicCsvCompilationTestHelper extends CompilationTestHelper {
	def void assertFileCompilesTo(CharSequence source, Map<String, CharSequence> expected) throws IOException {
		compile(source, [ r |

			expected.forEach [ fileName, content |
				val generatedFile = r.allGeneratedResources.filter[p1, p2|p1 == fileName]
				if (generatedFile.empty) {
					Assert.fail('''Excepted file «fileName» not found in generated sources''')
				} else {
					generatedFile.forEach [ p1, p2 |
						Assert.assertEquals(content.toString.trim, p2.toString.trim)
					]
				}
			]

		])
	}
}
