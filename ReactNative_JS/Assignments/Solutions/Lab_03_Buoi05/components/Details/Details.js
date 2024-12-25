import {StyleSheet,Dimensions } from 'react-native';


const screenWidth = Dimensions.get('window').width;
const styleDS = StyleSheet.create({
  container: {
    flex: 1,
  },
  textDT: {
    flexDirection: 'column', // Sắp xếp theo chiều dọc
    alignItems: 'flex-start', // Căn trái (hoặc 'center' để căn giữa)
  },
  bold: {
    fontSize:18,
    fontWeight: 'bold',
  },
  top: {
    flex: 2,
    width:'100%',
    flexDirection: 'row',
  },
  anh: {
    height: 140,
    width: 110,
    margin: 10,
    resizeMode: 'contain',
  },
  topText: {
    marginVertical: 5,
    fontSize: 18,
  },
  center: {
    backgroundColor: '#C4C4C4',
    flex: 6,
    alignItems: 'center',
    justifyContent: 'space-around',
  },
  buttonDetail: {
    height: 50,
    backgroundColor: '#234896',
    width: screenWidth - 20 * 2,
    justifyContent: 'center',
    alignItems: 'center',
    borderRadius: 15,
    marginBottom:20,
  },
});
export default styleDS;