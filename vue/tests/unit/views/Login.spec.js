import { shallowMount } from '@vue/test-utils';
import Login from '@/views/Login.vue';
import { setImmediate } from 'timers';
import { userLogin } from '@/api/user';

jest.mock('@/api/user', () => ({
    userLogin: jest.fn().mockResolvedValue({
        data: {
            code: 4002,
            data: 'mocked_token',
            message: 'Success'
        }
    })
}));
const flushPromises = () => new Promise(setImmediate);
describe('Login.vue', () => {
    let wrapper;

    beforeEach(() => {
        wrapper = shallowMount(Login);
    });

    afterEach(() => {
        wrapper.destroy();
    });

    it('renders the form', () => {
        expect(wrapper.find('a-form-stub').exists()).toBe(true);
    });

    it('calls handleSubmit when form is submitted', async () => {
        const handleSubmit = jest.spyOn(wrapper.vm, 'handleSubmit');
        wrapper.find('a-form-stub').trigger('submit');
        await flushPromises();
        expect(handleSubmit).toHaveBeenCalled();
    });

    it('displays an error message when username is not entered', async () => {
        wrapper.find('a-input-stub[placeholder="Userame"]').setValue('');
        wrapper.find('a-form-stub').trigger('submit');
        await flushPromises();

        expect(wrapper.text()).toContain('Please input your username!');
    });

    it('displays an error message when password is not entered', async () => {
        wrapper.find('a-input-stub[placeholder="Password"]').setValue('');
        wrapper.find('a-form-stub').trigger('submit');
        await flushPromises();

        expect(wrapper.text()).toContain('Please input your Password!');
    });

    it('does not display error messages when username and password are entered', async () => {
        wrapper.find('a-input-stub[placeholder="Userame"]').setValue('testuser');
        wrapper.find('a-input-stub[placeholder="Password"]').setValue('testpassword');
        wrapper.find('a-form-stub').trigger('submit');
        await flushPromises();

        expect(wrapper.text()).not.toContain('Please input your username!');
        expect(wrapper.text()).not.toContain('Please input your Password!');
    });
});
