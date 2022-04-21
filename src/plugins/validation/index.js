import * as veeValidate from 'vee-validate';
import rules from '@vee-validate/rules';
import yup from './yup';

Object.keys(rules).forEach((key) => {
  veeValidate.defineRule(key, rules[key]);
});

const modules = { yup, ...veeValidate };

export default modules;
