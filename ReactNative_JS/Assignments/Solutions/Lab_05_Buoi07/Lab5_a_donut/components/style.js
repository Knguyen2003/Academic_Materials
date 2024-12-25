import {
  StyleSheet,
} from 'react-native';


const styles = StyleSheet.create({
  container: {
    flex: 1,
    top: 25,
  },
  header: {
    flex: 0.5,
    padding: 15,
  },
  text: {
    fontSize: 20,
    marginBottom: 5,
  },
  title: {
    fontWeight: 'bold',
  },
  inputView: {
    flex: 1,
    justifyContent: 'center',
    width: '85%',
    paddingHorizontal: 15,
  },
  input: {
    borderWidth: 2,
    borderColor: '#FFCD29',
    padding: 10,
    backgroundColor: 'GRAY',
  },
  filterView: {
    flex: 1,
    flexDirection: 'row',
    justifyContent: 'space-around',
    alignItems: 'center',
  },
  button: {
    borderWidth: 2,
    borderRadius: 2,
    alignItems: 'center',
    width: 100,
    padding: 10,
  },
  selectedButton: {
    backgroundColor: 'orange', // Màu nút khi được chọn
  },
  main: {
    flex: 6,
    padding: 10,
  },
  hienThi: {
    flex: 1,
    padding: 10,
    flexDirection: 'row',
    backgroundColor: '#F4DDDD',
    marginBottom: 10,
    borderRadius: 2,
  },
  info: {
    marginLeft: 10,
    rowGap: 10,
    paddingTop: 10,
  },
  buttonDetail: {
    backgroundColor: '#F1B000',
    width: 50,
    height: 50,
    justifyContent: 'center',
    alignItems: 'center',
    borderTopLeftRadius: 40,
    borderTopRightRadius: 10,
    borderBottomLeftRadius: 10,
  },
  viewButton: {
    width: '100%',
    flex: 1,
    justifyContent: 'flex-end',
    alignItems: 'flex-end',
  },
  detailTop: {
    flex :1.5,
    alignItems :'center',
    justifyContent :'center',
  },
  detailCenter :{
    flex :1,
    justifyContent :'space-around'
  },
  detailBottom :{
    flex :0.5,
    justifyContent :'center',
    alignItems :'center',
  },
  buttonText :{
    fontWeight :'bold',
    color :'white',
    fontSize :30,
    
  },
  buttonView :{
    backgroundColor :'#f1b000',
    padding :10,
    alignItems :'center',
    width :'100%',

  }
});
export default styles;