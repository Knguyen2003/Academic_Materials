import { configureStore } from '@reduxjs/toolkit';
import bikeReducer from './slice';

const store = configureStore({
  reducer: {
    bikes: bikeReducer,
  },
});

export default store;
