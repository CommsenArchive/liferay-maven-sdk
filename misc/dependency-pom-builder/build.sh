
if [ $# -lt "2" ]
then
    echo "Usage: $0 <dependency name> <jar path>"
    exit 1
fi

DEP_NAME=$1
JAR_FOLDER=$2

if [ ! -d $JAR_FOLDER ]
then
    echo "Folder '$JAR_FOLDER' not found."
    exit 1
fi

JAR_FILES=`ls ${JAR_FOLDER}/*.jar`
if [ ! $? -eq 0 ] ; then
    echo "No jar files found in $JAR_FOLDER"
    exit 1
fi

LIFERAY_VERSION="5.2.3"
PLUGIN_DIR=liferay-${DEP_NAME}-lib
DEPENDECIES="${DEP_NAME}_dependencies.xml"
EXECUTIONS="${DEP_NAME}_executions.xml"
LIB_DIR="lib"
rm -rf ${PLUGIN_DIR}
mkdir -p ${PLUGIN_DIR}/${LIB_DIR}


for file in $JAR_FILES
do
file_name=`basename ${file}`
dep_name=`echo "$file_name" | sed 's/\.jar//'`

cp $file ${PLUGIN_DIR}/${LIB_DIR}

echo "<dependency>" >> $DEPENDECIES
echo "	<groupId>com.commsen.liferay.portal.libraries</groupId>" >> $DEPENDECIES
echo "	<artifactId>$dep_name</artifactId>" >> $DEPENDECIES
echo "	<version>$LIFERAY_VERSION</version>" >> $DEPENDECIES
echo "</dependency>" >> $DEPENDECIES


echo "<execution>" >> $EXECUTIONS
echo "	<id>install $dep_name</id>" >> $EXECUTIONS
echo "	<configuration>" >> $EXECUTIONS
echo "		<file>${LIB_DIR}/${file_name}</file>" >> $EXECUTIONS
echo "		<groupId>com.commsen.liferay.portal.libraries</groupId>" >> $EXECUTIONS
echo "		<artifactId>$dep_name</artifactId>" >> $EXECUTIONS
echo "		<version>$LIFERAY_VERSION</version>" >> $EXECUTIONS
echo "		<packaging>jar</packaging>" >> $EXECUTIONS
echo "          <generatePom>true</generatePom>" >> $EXECUTIONS
echo "	</configuration>" >> $EXECUTIONS
echo "	<phase>install</phase>" >> $EXECUTIONS
echo "	<goals>" >> $EXECUTIONS
echo "		<goal>install-file</goal>" >> $EXECUTIONS
echo "	</goals>" >> $EXECUTIONS
echo "</execution>" >> $EXECUTIONS

done

POM=${PLUGIN_DIR}/pom.xml

echo "<project xmlns=\"http://maven.apache.org/POM/4.0.0\"" >> $POM
echo "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" >> $POM
echo "        xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">" >> $POM
echo "        <modelVersion>4.0.0</modelVersion>" >> $POM
echo "        <groupId>com.commsen.liferay</groupId>" >> $POM
echo "        <artifactId>liferay-${DEP_NAME}-lib</artifactId>" >> $POM
echo "        <packaging>pom</packaging>" >> $POM
echo "        <version>5.2.3</version>" >> $POM
echo "        <name>Liferay ${DEP_NAME} libraries</name>" >> $POM
echo "        <dependencies>" >> $POM
cat $DEPENDECIES >> $POM
echo "        </dependencies>" >> $POM
echo "        <build>" >> $POM
echo "                <plugins>" >> $POM
echo "                        <plugin>" >> $POM
echo "                                <groupId>org.apache.maven.plugins</groupId>" >> $POM
echo "                                <artifactId>maven-install-plugin</artifactId>" >> $POM
echo "                                <executions>" >> $POM
cat $EXECUTIONS >> $POM
echo "                                </executions>" >> $POM
echo "                        </plugin>" >> $POM
echo "                </plugins>" >> $POM
echo "        </build>" >> $POM
echo "</project>" >> $POM


rm -f $DEPENDECIES
rm -f $EXECUTIONS


echo "Created Liferay dependency maven project in ${PLUGIN_DIR}"
echo "You can now do \"cd ${PLUGIN_DIR}; mvn install\" to install dependencies in local repository"
